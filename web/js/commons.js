var xmlHttp = false;
function initAJAX() {
    if(window.XMLHttpRequest) {
        <!--不是IE浏览器-->
        xmlHttp = new XMLHttpRequest();

    }
    <!--是IE浏览器-->
    else if(window.ActiveXObject){
        try{
            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
        }catch (e){
            try{
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }catch (e){
                window.alert("不支持ajax")
            }
        }
    }
}