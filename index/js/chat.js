function Connect(outputElId, inputElId, buttonId){
        this.outputEl = document.getElementById(outputElId);
        this.inputEl = document.getElementById(inputElId);
        this.buttonEl = document.getElementById(buttonId);
    };
Connect.prototype = {
    connection: function(){
        var $this = this;
        this.buttonEl.onclick = function(){
            this.connection.sendMessage(this.inputEl.value);
        }
        if ("WebSocket" in window){
        var conn = WebSocket("ws://localhost:5000/chat");
        conn.onmessage = function (evt){ 
            $this.render(evt.data);
        };
        conn.sendMessage = function (data){ 
            this.connection.send(data);
        };
      }else{
          //xhr
        getXhr = function(){
          var xhr;
          try {
            xhr = new ActiveXObject("Msxml2.XMLHTTP");
          } catch (e) {
            try {
              xhr = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (E) {
              xhr = false;
            }
          }
          if (!xhr && typeof XMLHttpRequest!='undefined') {
            xhr = new XMLHttpRequest();
          }
          return xhr;
        };
        conn = (function(){
          var xhr = this.getXhr();
          return setInterval(function(xhr){
            xhr.open('GET', '/chat', true);
            xhr.onreadystatechange = function(){
                if (xhr.readyState == 4) {
                    if(xhr.status == 200) {
                        $this.render(xhr.responseText);
                    }
                }
            }
          xhr.send(null);
          }, 15000);
        })();

        conn.sendMessage = function(data){
            var xhr = this.getXhr();
            xhr.open('GET', '/chat?post=' + data, true);
            xhr.send(null);
        }
      }
      return conn;
    },
    render: function(data){
        this.inputEl += data;
    }
};