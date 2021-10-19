
let appComponents ={
    htmlForm:{
        render: function(){
            let  me= this;

            var formToRender='<section class="inputform">'
            formToRender += '<h2>' + me.formTitle + '</h2>';

            formToRender += '<form action="' + me.url + '" method="' + me.method + '">';

            me.items.forEach(item=>{
                formToRender += '<label for="'+ item.id +'">'+item.label+':</label><br>';
                var inputString="";
               if(item.type==='select') {
                    formToRender += '<select name ="' + item.name + '" id = "' + item.id + '">';
                    let selectOptions;
                    if (item.select && item.select.data){
                        selectOptions = item.select.data;

                    }else if (item.select && item.select.url){

                        /*var ajaxReq = new XMLHttpRequest();
                        ajaxReq.onreadystatechange = function(){
                            if (ajaxReq.readyState == XMLHttpRequest.DONE){
                                if (ajaxReq.status == 200){
                                    selectOptions = eval('(' + ajaxReq.responseText + ')').list;
                                }
                            }
                        }

                        ajaxReq.open('get', item.select.url, false);
                        ajaxReq.send();*/
                        selectOptions=appComponents.ajaxGetFunction.ajaxwithreturn(item.select.url);

                    }

                    selectOptions.forEach(option =>{
                        formToRender += '<option val="' + option[item.select.optionMap.value]+ '">' + option[item.select.optionMap.display] + '</option>';
                    })

                    formToRender += '</select></br>';

                }else if(item.type==='textarea'){
                    formToRender+='<textarea id="' + item.id +'" name="' + item.name + '" rows="5" cols="20"></textarea><br>';

                }else{
                   formToRender+='<input type="'+item.type+'" id="'+item.id+'" name="'+item.name+'"><br>';
               }
            });

            formToRender += '<input type="' + me.submitBtn.type + '" value="' + me.submitBtn.value + '"></form></section>';

            document.getElementById(this.renderId).innerHTML = formToRender;


        }
    },
    htmlTable:{
        renders:function(){
            let me=this;
            let  dataTable = '<h2>' + me.tableTitle + '</h2><br/>';

            me.buttons.forEach(btn=>{
                dataTable += '<button class="" type="button" id="' + btn.id + '">' + btn.label + '</button>';
            });

            dataTable += '<br/><table>';

            dataTable += '<thead><tr>';
            dataTable+='<th>#</th>'

            me.columns.forEach(column=>{
                dataTable += '<th>' + column.label + '</th>';

            });
            dataTable += '<br/></tr></thead>';


            dataTable += '<tbody>';

            const xhr=new XMLHttpRequest();
            xhr.onreadystatechange=function () {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    let data=eval('('+xhr.responseText+')') ;
                    data.list.forEach(datum=>{
                        let ids=datum[me.id];
                        dataTable += '<tr><td><input type="checkbox" name="checks" class="check" value="'+ids+'"/></td>'

                        console.log(ids);
                        me.columns.forEach(column=>{
                            dataTable+='<td class="tabledata">'+datum[column.dataIndex]+'</td>'
                        })
                        dataTable+='</tr><br/>'
                    })
                    dataTable+='</tbody>'
                    dataTable+='</table>'
                    document.getElementById(me.renderTo).innerHTML=dataTable;
                    console.log(dataTable)

                }
            }
            xhr.open("GET",me.url,false);
            xhr.send();
            me.buttons.forEach(btn=>{
                let eachid=btn.id;
                console.log(eachid)
                //let checkboxes=document.querySelectorAll("check");
                document.getElementById(eachid).addEventListener("click",btn.handler);
            });
        }

    },
    /*navbar: function (){
        let me=this;

        card+='<img src="../images/person.jpg" className="card-img-top">';

    },*/

   /* homepage: {
        homeRender: function () {
            let me = this;
            var card = '<div class="card-arrange">';
            const xhr=new XMLHttpRequest();
            xhr.onreadystatechange=function () {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    let data = eval('(' + xhr.responseText + ')');
                    data.forEach(datum=>{
                        me.items.forEach(item=>{
                            card+='<h5>datum[item.dataIndex]</h5>'

                    })
                        card+='<a href="'+me.links.hreflink+'" class="card-link">'+me.links.display+'</a>'
                    })

                        document.getElementById(me.renderTo).innerHTML=card;


                    }

                    }
            xhr.open("GET",me.url,true);
            xhr.send();

                }
        },*/
    htmlToNavBar: {
        render: function(){
            let me = this;

            let topNavToolBar = '';

            me.links.forEach(link=>{
                topNavToolBar += '<a class="' + link.class + '" id="' + link.id + '" href="#">' + link.label + '</a>';
            });

            document.getElementById(me.renderTo).innerHTML = topNavToolBar;

            me.links.forEach(link=>{
                document.getElementById(link.id).addEventListener("click", link.handler);
            });

        },
        changeStyle: function(linkId){
            let me = this;


            me.links.forEach(link=>{
                if (link.id === linkId){
                    document.getElementById(linkId).classList.add("active");

                }else{
                    document.getElementById(linkId).classList.remove("active");

                }
            });
        }
    },ajaxGetFunction:{
        ajaxwithreturn: function (url) {
            var ajaxReq = new XMLHttpRequest();
            let ajaxlist;
            ajaxReq.onreadystatechange = function(){

                if (ajaxReq.readyState == 4 && ajaxReq.status == 200) {
                    ajaxlist = eval('(' + ajaxReq.responseText + ')').list;
                }
            }

            ajaxReq.open('get', url, false);
            ajaxReq.send();
            return ajaxlist;

        }
    },ajaxPostFunction:{
        ajaxwithreturn: function (url,ajaxdata) {
            var ajaxReq = new XMLHttpRequest();
            let ajaxlist;
            ajaxReq.onreadystatechange = function(){

                if (ajaxReq.readyState == 4 && ajaxReq.status == 200) {
                    ajaxlist = eval('(' + ajaxReq.responseText + ')');
                }
            }

            ajaxReq.open('POST', url, false);
            console.log("hiiii"+ajaxdata);
            ajaxReq.setRequestHeader("Content-type","application/json");
            ajaxReq.send(ajaxdata);
            return ajaxlist;

        }

    }


};





