package com.ellonas.tripsanddrivers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LogFilePrinter {

	private File logFile = new File("TripsAndDriver.txt");
	private PrintWriter writer;
	private Scanner scanner;

	private void createLogFile() {
		try {
			logFile.createNewFile();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void printLog(String log) {

		try {
			FileWriter fileWriter = new FileWriter(logFile, true);
			writer = new PrintWriter(fileWriter);
			writer.println(log);
			writer.close();
		} catch (IOException e1) {
			// create file if it doesn't exist
			createLogFile();
		}
	}

	public void removeLog(String keyWord) {
		try {
			scanner = new Scanner(logFile);
			StringBuilder newContent = new StringBuilder(); // scan the file and save all lines that don't contain
															// keyword

			while (scanner.hasNext()) {
				String currentLine = scanner.nextLine();
				if (!currentLine.contains(keyWord)) {
					newContent.append(currentLine);
					newContent.append("\n"); // new line
				}
			}
			scanner.close();
			rewriteFile(newContent.toString());
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
	}

	private void rewriteFile(String newContent) {
		try {
			FileWriter removeLine = new FileWriter(logFile);
			BufferedWriter replacetext = new BufferedWriter(removeLine);
			writer = new PrintWriter(replacetext);
			writer.write(newContent);
			writer.close();
		} catch (IOException e3) {
			e3.printStackTrace();
		}
		
	}

	public File getLogFile() {
		return this.logFile;
	}
}
