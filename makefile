all:
	javac *.java
	jar cvfe EssayWriter.jar EssayWriter *.class
	rm *.class

dev:
	javac *.java
	jar cvfe EssayWriter.jar EssayWriter *.class