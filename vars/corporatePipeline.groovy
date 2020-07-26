def call(body) {
    def pipelineParams= [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()

    pipeline {
    agent none
    stages {
        stage('verify') {
            steps {
                deploy(name:'Hello',dayOfWeek:'Tues')
            }
        }
    }
  }
}
