#!/usr/bin/env groovy

import org.apache.commons.lang.StringUtils

def call(String filter_string, int occurrence) {
    def logs = currentBuild.rawBuild.getLog(10000).join('\n')
    int count = StringUtils.countMatches(logs, filter_string);
    if (count > occurrence -1) {
        currentBuild.description = 'Build is success but manually tweeted sorry for this'
        currentBuild.result='UNSTABLE'
    }
}
