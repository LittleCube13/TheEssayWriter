all:
	javac *.java
	jar cvfe EssayWriter.jar EssayWriter *.class
	make clean

dev:
	javac *.java
	jar cvfe EssayWriter.jar EssayWriter *.class

clean:
	rm *.class || continue
	rm leviathanyaml/*.class || continue

clean-all:
	make clean
	rm EssayWriter.jar || continue
