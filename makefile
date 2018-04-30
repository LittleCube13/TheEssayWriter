all: dev clean

offline: dev

dev: submodule
	javac *.java
	jar cvfe EssayWriter.jar EssayWriter *

submodule:
	git submodule init
	git submodule update
	git submodule foreach git pull origin master

clean:
	rm *.class || continue
	rm -rf leviathanyaml || continue

clean-all:
	make clean
	rm *.jar || continue
