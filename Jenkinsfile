import java.nio.charset.StandardCharsets

/**
 * 只支持 REST API
 */
// get put 请求
def get_req(url) {
    def req = new URL(url).openConnection();
    req.setRequestProperty("Content-Type", "application/json")
    def resCode = req.getResponseCode();
    println("Request URL ${url}, ResponseCode: ${resCode}");
    def res = req.getInputStream()
    def resData = res.getText()
    if (resCode.equals(200)) {
        def header = req.getHeaderFields()
        println("Request URL ${url}, ResponseCode: ${resCode}, data: ${resData}");
        return [data: resData, header: header]
    } else {
        println("Request URL ${url} 请求失败了...  ${resData}")
    }
}


//定义 post put请求
def post_req(url, data, method = "POST") {
    def req = new URL(url).openConnection();
    req.setRequestMethod(method)
    req.setDoOutput(true)
    req.setRequestProperty("Content-Type", "application/json")
    byte[] message = data.getBytes(StandardCharsets.UTF_8)
    req.getOutputStream().write(message);
    def resCode = req.getResponseCode();
    println("Request URL ${url}, ResponseCode: ${resCode}");
    def res = req.getInputStream()
    def resData = res.getText()
    if (resCode.equals(200)) {
        def header = req.getHeaderFields()
        res.close()
        println("Request URL ${url}, ResponseCode: ${resCode}, data: ${resData}");
        return [data: resData, header: header]
    } else {
        println("Request URL ${url} 请求失败了...  ${resData}")
    }
}



pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                script{
                    println(get_req("http://192.168.31.222:38001/control/services"))

                    def message = '{"enable":false}'
                    println(post_req("http://192.168.31.222:38001/control/protect/protectStatus",message,"PUT"))
                }
            }
        }
    }
}
