all:
	make dev
	make clean

dev:
	javac src/*.java
	jar cvfe EssayWriter.jar src.EssayWriter *

clean:
	rm src/*.class || continue
	rm leviathanyaml/*.class || continue

clean-all:
	make clean
	rm EssayWriter.jar || continue
