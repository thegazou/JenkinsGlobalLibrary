#!/usr/bin/env groovy
class SvnHelper {

    int getRevisionNumber(String userName, String password)
    {
        def command = ["svn", "info", "http://svn.sylvac2000/svn/SylvacUniversalSoftware/trunk/", "--username", userName, "--password", password].execute()
        command.waitFor()
        def revisionNumber = command.text.split("Revision: ")[1].split("\\s")[0]
        //println "Exit value: ${command.exitValue()}"
        //println "Revision number = ${revisionNumber}"
        return revisionNumber.toInteger()
    }
    static void main(String... args) {
        println getRevisionNumber("ngo","29_TarTarin")
    }

}
