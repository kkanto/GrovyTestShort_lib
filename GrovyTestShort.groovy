
      package de.allianz.GrovyTestShort

      def lib = library identifier: 'BizDevOps_JSL@develop', retriever: modernSCM(
      [\$class: 'GitSCMSource',
        remote: 'https://github.developer.allianz.io/JEQP/BizDevOps-JSL.git',
        credentialsId: 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])

      def jslMaven      = lib.de.allianz.bdo.pipeline.JSLMaven.new()
      def jslGradle     = lib.de.allianz.bdo.pipeline.JSLGradle.new()
      def jslNexus      = lib.de.allianz.bdo.pipeline.JSLNexus.new()
      def jslSonarqube  = lib.de.allianz.bdo.pipeline.JSLSonarqube.new()

      def build() {
        jslMaven.build()
      }

      def componentTest {
        jslMaven.testunit("component")
      }

      def integrationTest {
        jslMaven.testunit("integration")
      }

      def uatTest {
        jslMaven.testunit("uat")
      }

      def acceptanceTest {
        jslMaven.testunit("acceptance")
      }

      
      def callSonarqube() {
         jslSonarqube.call()
      }
      

      def publishArtifacts() {
        jslNexus.push()
      }

    