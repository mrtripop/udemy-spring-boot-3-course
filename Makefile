setup:
	cd commitlint && npm install
	cd commitlint && npm run add-commitlint-git-hook

clean:
	mvn clean
	cd commitlint && rm -rf node_modules
	cd commitlint && npm install
