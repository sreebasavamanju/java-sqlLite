package com.learn.db.java_sqlLite;

public class StatementResult {

	private PrepareResult prepareResult;
	
	private Statement statement;

	public PrepareResult getPrepareResult() {
		return prepareResult;
	}

	public void setPrepareResult(PrepareResult prepareResult) {
		this.prepareResult = prepareResult;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public StatementResult(PrepareResult prepareResult, Statement statement) {
		this.prepareResult = prepareResult;
		this.statement = statement;
	}
	
	
	
	
}
