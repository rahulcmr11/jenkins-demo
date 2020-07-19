import groovy.json.JsonSlurper
@Library('github.com/releaseworks/jenkinslib') _ 
String CODE_REPO = "https://github.com/rahulcmr11/jenkins-demo.git"
node {

    ws("jenkins-demo") {

        stage('checkout-git') {

           checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'cicd', url: CODE_REPO]]]

        }
	    
	    stage('if_all_file_good') {
		    
		println("All look good . Please deploy ")	
        }
	    
	    stage('deploy_step') {
		    
	bat '''
		copy C:\Program Files (x86)\Jenkins\workspace\step1-dev\index.html C:\Apache24\htdocs\
		'''
			
        }
	    
        }
        }

