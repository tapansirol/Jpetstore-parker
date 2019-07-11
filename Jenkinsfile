node {
	currentBuild.displayName = "1.${BUILD_NUMBER}"
	def GIT_COMMIT
  stage ('cloning the repository'){
	  
      def scm = git 'https://github.com/tapansirol/jpetstore-demo01'
	  GIT_COMMIT = sh(returnStdout: true, script: "git rev-parse HEAD").trim()
	  echo "AAAA ${GIT_COMMIT}"
	  //echo "BBBB ${scm}"
	  //GIT_COMMIT = scm.GIT_COMMIT
	   //echo "**** ${GIT_COMMIT}"
	  
  }
	
 
  stage ('Build') {
      withMaven(jdk: 'JDK_local', maven: 'MVN_Local') {
      sh 'mvn clean package'
	      echo "**** ${GIT_COMMIT}"
	//step($class: 'UploadBuild', tenantId: "5ade13625558f2c6688d15ce", revision: "${GIT_COMMIT}", appName: "JPetStore", requestor: "admin", id: "${newComponentVersionId}" )
	
	     
    }
  }
	stage('SonarQube Analysis'){
		def mvnHome = tool name : 'MVN_Local', type:'maven'
		withSonarQubeEnv('sonar-server'){
			 "SONAR_USER_HOME=/opt/bitnami/jenkins/.sonar ${mvnHome}/bin/mvn sonar:sonar"
			sh  "${mvnHome}/bin/mvn sonar:sonar"
		}
	}
stage ("Appscan"){
	 
	//sleep 40
     //appscan application: '17969f05-19dd-4143-b7e2-c52a3336db18', credentials: 'asoc', failBuild: true, failureConditions: [failure_condition(failureType: 'high', threshold: 4)], name: '17969f05-19dd-4143-b7e2-c52a3336db185549', scanner: static_analyzer('/var/jenkins_home/jobs/JPetStore-test'), type: 'Static Analyzer', wait: true
	//appscan application: '13a06581-eb2c-4b1f-8002-6722126ae44e', credentials: 'ASOC_Staging', failBuild: true, failureConditions: [failure_condition(failureType: 'high', threshold: 20)], name: 'JPS_test', scanner: static_analyzer('C:\\Users\\kalra_m\\eclipse-workspace-latest\\jpetstore-6'), type: 'Static Analyzer', wait: true
	 //appscan application: '17969f05-19dd-4143-b7e2-c52a3336db18', credentials: 'asoc', failBuild: true, failureConditions: [failure_condition(failureType: 'high', threshold: 20)], name: '17969f05-19dd-4143-b7e2-c52a3336db185549', scanner: static_analyzer('C:\\Program Files (x86)\\Jenkins\\jobs\\JPetStore-Test'), type: 'Static Analyzer', wait: true
//appscan application: 'd25a0655-7bd2-418f-8a34-ca8338e411c0', credentials: Credential for ASOC', name: 'd25a0655-7bd2-418f-8a34-ca8338e411c09964', scanner: static_analyzer(hasOptions: false, target: ''), type: 'Static Analyzer'
//appscan application: 'd25a0655-7bd2-418f-8a34-ca8338e411c0', credentials: 'Credential for ASOC', failBuild: true, failureConditions: [failure_condition(failureType: 'high', threshold: 20)], name: 'd25a0655-7bd2-418f-8a34-ca8338e411c09964', scanner: static_analyzer('/var/jenkins_home/jobs/JPetStore-test'), type: 'Static Analyzer', wait: true

	//appscan application: '17969f05-19dd-4143-b7e2-c52a3336db18', credentials: 'Credential for ASOC', failBuild: true, failureConditions: [failure_condition(failureType: 'high', threshold: 20)], name: 'test_07012019', scanner: static_analyzer(hasOptions: false, target: '/var/jenkins_home/jobs/jpetstore'), type: 'Static Analyzer', wait: true
 }
  stage('Publish Artificats to UCD'){
	  
   step([$class: 'UCDeployPublisher',
        siteName: 'ucd-server',
        component: [
            $class: 'com.urbancode.jenkins.plugins.ucdeploy.VersionHelper$VersionBlock',
            componentName: 'JpetComponent',
            createComponent: [
                $class: 'com.urbancode.jenkins.plugins.ucdeploy.ComponentHelper$CreateComponentBlock',
                componentTemplate: '',
                componentApplication: 'JPetStore'
            ],
            delivery: [
                $class: 'com.urbancode.jenkins.plugins.ucdeploy.DeliveryHelper$Push',
                pushVersion: '1.${BUILD_NUMBER}',
                //baseDir: '/var/jenkins_home/workspace/JPetStore/target',
		    baseDir: '/var/jenkins_home/workspace/${JOB_NAME}/target',
                fileIncludePatterns: '*.war',
                fileExcludePatterns: '',
               // pushProperties: 'jenkins.server=Jenkins-app\njenkins.reviewed=false',
                pushDescription: 'Pushed from Jenkins'
            ]
        ]
    ])
	  
		//sh 'env > env.txt'
	//	readFile('env.txt').split("\r?\n").each {
	//	println it
	//	}
	echo "(*****)"
	  echo "${UUID}"
	
	  echo "Demo1234 ${JpetComponent_VersionId}"
	  def newComponentVersionId = "${JpetComponent_VersionId}"
	  step($class: 'UploadBuild', tenantId: "5ade13625558f2c6688d15ce", revision: "${GIT_COMMIT}", appName: "JPetStore", requestor: "admin", id: "${newComponentVersionId}" )
	  echo "Demo123 ${newComponentVersionId}"
	sleep 25
	  step([$class: 'UCDeployPublisher',
		deploy: [ createSnapshot: [deployWithSnapshot: true, 
			 snapshotName: "1.${BUILD_NUMBER}"],
			 deployApp: 'JPetStore', 
			 deployDesc: 'Requested from Jenkins', 
			 deployEnv: 'JPetStore_Dev', 
			 deployOnlyChanged: false, 
			 deployProc: 'Deploy-JPetStore', 
			 deployReqProps: '', 
			 deployVersions: "JpetComponent:1.${BUILD_NUMBER}"], 
		siteName: 'ucd-server'])
 }
 
stage ('HCL One Test') {
	sleep 25
	// echo 'Executing HCL One test ... '
	//sh '/var/jenkins_home/onetest/hcl-onetest-command.sh'
 }

}

