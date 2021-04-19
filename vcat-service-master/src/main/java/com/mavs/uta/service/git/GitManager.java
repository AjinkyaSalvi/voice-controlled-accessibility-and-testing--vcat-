package com.mavs.uta.service.git;

import java.io.File;
import java.util.Iterator;

import org.eclipse.jgit.api.AddCommand;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.CommitCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullCommand;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.errors.AbortedByHookException;
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.NoFilepatternException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.NoMessageException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.api.errors.UnmergedPathsException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.PushResult;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

public class GitManager {

	public void commitFiles(String username,String password) {
		String localPath = "c://test" + "//" + username;
		String URL="https://github.com/prasadkrn83/VCAT_Generated_Tests.git";
		
		try {

			Git git = null;
			
			createLocalRepo(localPath, URL);
			git = Git.open(new File(localPath));
			
			pullFromRemoteRepo(git);
			
			UsernamePasswordCredentialsProvider cp = new UsernamePasswordCredentialsProvider(username, password);

			// add
			performAddAction(git);
			// commit
			performCommitAction(git,username);
			// push
			performPushAction(git, cp);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	private static void createLocalRepo(String localPath,String URL) throws InvalidRemoteException, TransportException, GitAPIException {
		
		FileRepositoryBuilder repositoryBuilder = new FileRepositoryBuilder();
		repositoryBuilder.addCeilingDirectory(new File(localPath));
		repositoryBuilder.findGitDir(new File(localPath));

		if (repositoryBuilder.getGitDir() == null) {

			System.out.println("local repo not exisiting...cloning from remote");
			CloneCommand cloneCommand = Git.cloneRepository();

			cloneCommand.setURI(URL);
			cloneCommand.setDirectory(new File(localPath));
			cloneCommand.call();
		}
		
	}
	
	private static void pullFromRemoteRepo(Git git) {
		System.out.println("pull from remote to update local repo");

		PullCommand pullCmd = git.pull();
		try {
			pullCmd.call();
		} catch (GitAPIException e) {
			e.printStackTrace();
		}
	}
	
	private static void performAddAction(Git git) throws GitAPIException {
		
		AddCommand ac = git.add();
		ac.addFilepattern(".");
		try {
			ac.call();
		} catch (NoFilepatternException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void performCommitAction(Git git, String username) throws UnmergedPathsException, AbortedByHookException, GitAPIException {
		
		CommitCommand commit = git.commit();

		commit.setCommitter(username, username).setMessage("File created from VCAT Service");
		try {
			commit.call();
		} catch (NoHeadException e) {
			e.printStackTrace();
		} catch (NoMessageException e) {
			e.printStackTrace();
		} catch (ConcurrentRefUpdateException e) {
			e.printStackTrace();
		} catch (WrongRepositoryStateException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void performPushAction(Git git,UsernamePasswordCredentialsProvider cp) throws TransportException, GitAPIException {
		
		PushCommand pc = git.push();
		pc.setCredentialsProvider(cp).setForce(true).setPushAll();
		try {
			Iterator<PushResult> it = pc.call().iterator();
			if (it.hasNext()) {
				System.out.println(it.next().getRemoteUpdates().toString());
			}
		} catch (InvalidRemoteException e) {
			e.printStackTrace();
		}
		
	}
}
