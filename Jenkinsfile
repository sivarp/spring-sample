node {
	stage('Build') {
		docker.image('maven:3-alpine').inside {
			sh 'mvn --version'
		}
	}

	stage 'Test'
	stage 'Deploy'
}