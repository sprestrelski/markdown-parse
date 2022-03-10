test-windows: MarkdownParse.class MarkdownParseTest.class.win
test-linux: MarkdownParse.class MarkdownParseTest.class.lin
CLASSPATH = "lib/*;."

MarkdownParse.class: MarkdownParse.java
	javac MarkdownParse.java

MarkdownParseTest.class.win: MarkdownParseTest.java MarkdownParse.class
	javac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.java
	java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest

MarkdownParseTest.class.lin: MarkdownParseTest.java MarkdownParse.class
	javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java
	java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest

TryCommonMark.class: TryCommonMark.java
	javac -g -cp $(CLASSPATH) TryCommonMark.java

TryCommonMark: TryCommonMark.class
	java -cp $(CLASSPATH) TryCommonMark

clean:
	rm -f MarkdownParse.class
	rm -f MarkdownParseTest.class	
