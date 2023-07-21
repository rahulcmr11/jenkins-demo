import groovy.json.JsonSlurper
@Library('github.com/releaseworks/jenkinslib') _ 
String CODE_REPO = "https://github.com/rahulcmr11/jenkins-demo.git"
node {

    ws("jenkins-demo") {

        stage('checkout-git') {

           checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'demo-jenkins', url: CODE_REPO]]]

        }
	    
	    stage('if_all_file_good') {
		    
		println("All look good . Please deploy")	
        }
	    
	    stage('deploy_step') {
			
			sh '''
			
			cp C:/Users/rahulranjan5/.jenkins/jenkins-demo/index.html C:/trainings/httpd-2.4.57-win64-VS17/Apache24/htdocs/
			
			'''
		    
	println("New file published")
			
        }
	    
        }
        }

