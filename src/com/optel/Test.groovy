package com.optel

// http request

def res = new URL("http://127.0.0.1:38001/control/services").openConnection();
def getRC = res.getResponseCode();
println(getRC)

def hs = res.getHeaderFields()
println(hs)

def data = res.getContent()
println(data)


def dd = new URL("http://127.0.0.1:38001/control/services").text

println(dd)

def post = new URL("http://127.0.0.1:38001/control/protect/protectStatus").openConnection();
def message = '{"enable":false}'
post.setRequestMethod("PUT")
post.setDoOutput(true)
post.setRequestProperty("Content-Type","application/json")
post.getOutputStream().write(message.getBytes("UTF-8"));
def postRC = post.getResponseCode();
println(postRC);
if(postRC.equals(200)) {
    println(post.getInputStream().getText());
}

