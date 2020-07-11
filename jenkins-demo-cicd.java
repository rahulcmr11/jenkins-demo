import groovy.json.JsonSlurper
@Library('github.com/releaseworks/jenkinslib') _ 
String CODE_REPO = "https://github.com/rahulcmr11/jenkins-demo.git"
node {

    ws("jenkins-demo") {

        stage('checkout-git') {

           checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'cicd', url: CODE_REPO]]]

        }
	    
	    stage('pexecute_run_step') {
		    
		sh '''
			whoami
      sudo service apache2 stop
		'''	
        }
	    
        }
        }
