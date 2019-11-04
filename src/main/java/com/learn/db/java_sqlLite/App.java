package com.learn.db.java_sqlLite;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		App app = new App();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			app.printPrompt();
			String cmd = scanner.nextLine();
			if (StringUtils.startsWith(cmd, ".")) {
				switch (checkMetaCommand(cmd)) {
				case META_SUCCESS:
					continue;
				case UNRECOGNIZED:
					System.out.println("Unrecognized command '" + cmd + "'");
					continue;
				}
			}
			StatementResult prepareStatement = prepareStatement(cmd);
			switch (prepareStatement.getPrepareResult()) {
			case PREPARE_SUCCESS:
				break;
			case PREPARE_UNRECOGNIZED:
				System.out.println("Unrecognized keyword at start of  '" + cmd + "'");
				continue;
			}

			app.executeStatement(prepareStatement.getStatement());
			System.out.println("Executed.");
		}
	}

	private static CommandType checkMetaCommand(String cmd) {
		if (".exit".equals(cmd)) {
			System.out.print("Exiting Console.");
			System.exit(0);
		} else {
			return CommandType.UNRECOGNIZED;
		}
		return CommandType.META_SUCCESS;
	}

	private static StatementResult prepareStatement(String cmd) {

		if (StringUtils.startsWith(cmd, "insert")) {

			return new StatementResult(PrepareResult.PREPARE_SUCCESS, Statement.STATEMENT_INSERT);
		}

		if (StringUtils.startsWith(cmd, "select")) {
			return new StatementResult(PrepareResult.PREPARE_SUCCESS, Statement.STATEMENT_SELECT);
		}

		return new StatementResult(PrepareResult.PREPARE_SUCCESS, null);
	}

	private void executeStatement(Statement statement) {
		switch (statement) {
		case STATEMENT_INSERT:
			System.out.println("This is where we would do an insert");
			break;
		case STATEMENT_SELECT:
			System.out.println("This is where we would do an select");
			break;
		}
	}

	private void printPrompt() {
		System.out.print("db >");
	}
}
