package edu.gatech.cs6310.project1.test;

import java.io.OutputStream;
import java.io.PrintStream;

public class Constants {
	public static final int KB = 1024;
	public static final int MB = 1024*1024;
	public static final int GB = 1024*1024*1024;
	
	protected static final String[] args3x3T1 = {"-t","1","-b","1","-l","1","-r","1","-d","3"};
	protected static final String[] args3x3T10 = {"-t","10","-b","10","-l","10","-r","10","-d","3"};
	protected static final String[] args3x3T100 = {"-t","100","-b","100","-l","100","-r","100","-d","3"};
	
	protected static final String[] args10x10T1 = {"-t","1","-b","1","-l","1","-r","1","-d","10"};
	protected static final String[] args10x10T10 = {"-t","10","-b","10","-l","10","-r","10","-d","10"};
	protected static final String[] args10x10T100 = {"-t","100","-b","100","-l","100","-r","100","-d","10"};
	
	protected static final String[] args100x100T1 = {"-t","1","-b","1","-l","1","-r","1","-d","100"};
	protected static final String[] args100x100T10 = {"-t","10","-b","10","-l","10","-r","10","-d","100"};
	protected static final String[] args100x100T100 = {"-t","100","-b","100","-l","100","-r","100","-d","100"};
	
	protected static final String[] args10x10T1T10 = {"-t","1","-b","1","-l","10","-r","10","-d","10"};
	protected static final String[] args10x10T10T100 = {"-t","10","-b","10","-l","100","-r","100","-d","10"};
	protected static final String[] args10x10T50T100 = {"-t","50","-b","50","-l","100","-r","100","-d","10"};
	
	protected static final PrintStream outNull = new PrintStream(new OutputStream() {
											        public void write(int b) {
											            //DO NOTHING
											        }
											    });
	
	
}
