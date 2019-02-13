.PHONY: build clean run

build: tema2

run:
	java -Xmx1G -cp ./bin Main

tema2:
	javac -d ./bin src/*.java src/*/*.java

clean:
	rm -rf ./bin
