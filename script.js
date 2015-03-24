
var count = 0;

function copypast_nick(){
    document.getElementById('first_nick').value = document.getElementById('second_nick').value;
    document.getElementById('second_nick').value = "";
    showMe(this,1);
    document.getElementById('checkbox_nick').value = "1";
    document.innickname.checkbox_nick.checked == false;
}

var copypas = (function () {
    count = 0;
    return function () {
        var arr = new Array();
        var c = document.getElementById('secondspace').value;
        if (document.getElementById('firstspace').value != "") {
            count++;
            if (document.getElementById('firstspace').value != "¬ведите сообщение") {
                document.getElementById('secondspace').value = c + "(" + count + ")" + "я: " + document.getElementById('firstspace').value + "\n";
            }
        }
        arr = (document.getElementById('secondspace').value).split('\n');
        secondspace.scrollTop = secondspace.scrollHeight;
    };
})();

function delete_some() {
    var c = document.getElementById('delete_massage').value;
    var arr = new Array();
    var arr2 = new Array();
    var result = new Array();
    var tmp = "";
    arr2 = (document.getElementById('secondspace').value).split('\n');
    for (var i = 0; i < arr2.length; i++) {
        tmp += arr2[i] + " ";
    }
    arr2 = tmp.split(' ');
    if (c > 0 && c <= count) {
        tmp = "";
        for (var i = 0; i < (arr2.length) / 2; i++) {
            if (arr2[i * 2] != null) {
                if (arr2[i * 2] != "") {
                    arr[i] = arr2[i * 2];
                }
            }
        }
        arr.splice(c, 1);
        document.getElementById('secondspace').value = "";
        for (var i = 1; i < arr.length; i++) {
            tmp += "(" + i + ")" + "я: " + arr[i] + "\n";
        }
        if (count != 0) {
            count--;
        }
        document.getElementById('secondspace').value = tmp;
    }
    showMe(this, 3);
}

function to_change_massage() {
    var c = document.getElementById('change_number').value;
    var massage = document.getElementById('change_massage').value;
    var arr = new Array();
    var arr2 = new Array();
    var result = new Array();
    var tmp = "";
    arr2 = (document.getElementById('secondspace').value).split('\n');
    for (var i = 0; i < arr2.length; i++) {
        tmp += arr2[i] + " ";
    }
    arr2 = tmp.split(' ');
    if (c > 0 && c <= count) {
        tmp = "";
        for (var i = 0; i < (arr2.length) / 2; i++) {
            if (arr2[i * 2] != null) {
                if (arr2[i * 2] != "") {
                    arr[i] = arr2[i * 2];
                }
            }
        }
        arr.splice(c, 1, massage);
        document.getElementById('secondspace').value = "";
        for (var i = 1; i < arr.length; i++) {
            tmp += "(" + i + ")" + "я: " + arr[i] + "\n";
        }
        if (count != 0) {
            count--;
        }
        document.getElementById('secondspace').value = tmp;
    }
    showMe(this, 2);
}

function showMe(box,div_numder) {
    var vis = (box.checked) ? "block" : "none";
    var c = 'div' + div_numder;
    document.getElementById(c).style.display = vis;
}

function delete_all() {
    document.getElementById('secondspace').value = "";
}

function create_checkbox() {
    var btn = document.createElement('input');
    btn.id = 'b1';
    btn.type = 'checkbox';
    btn.value = 'button 1';
    btn.setAttribute('onclick', 'obj.HandleClick1();');
    document.body.appendChild(btn);
}

