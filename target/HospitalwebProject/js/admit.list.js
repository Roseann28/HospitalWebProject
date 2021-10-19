let admitdetails={
    url: "http://localhost:8080/HospitalwebProject/admission/list",
    tableTitle:'Admission Table',
    renderTo: 'renderer',
    id:'patientId',
    columns:[{
        label:"Patient ID",
        dataIndex:"patientId"
    },{
        label:"Room Number",
        dataIndex: "roomNumber"
    },{
        label: "Date Of Admission",
        dataIndex: "dateOfAdmission"
    },{
        label: "Present Date",
        dataIndex: "presentDate"
    },{
        label: "Progress",
        dataIndex: "progress"
    }],
    buttons:[
        {
            id:'add.admit',
            label:'add',
            handler: function () {
                appComponents.htmlForm.render.call({
                    url: "./admission/save",
                    method: "POST",
                    formTitle: 'Admission',
                    renderId:'renderer',
                    items: [{
                        label: "Staff ID",
                        name: "staffId",
                        id: "staffId",
                        type: "number"

                    },{

                        label: "Patient ID",
                        name: "patientId",
                        id: "patientId",
                        type: "number"
                    },{
                        label: "Room number",
                        name: "roomNumber",
                        id: "roomNumber",
                        type: "text"
                    },{
                        label: "Date of Admission",
                        name: "dateOfAdmission",
                        id: "dateOfAdmission",
                        type: "date"
                    },{
                        label: "Present Date",
                        name: "presentDate",
                        id: "presentDate",
                        type: "date"
                    },{
                        label: "Progress",
                        name: "progress",
                        id: "progress",
                        type: "text"
                    }],
                    submitBtn: {
                        type: 'submit',
                        value: 'Submit'

                    }
                })

            }
        },
        {
            id:'delete.admit',
            label: 'delete',
            handler: function () {
                let checkedarray=new Array();
                let data;
                var markedCheckbox=document.getElementsByName('checks');
                let arrays;


                for (var i=0;i<markedCheckbox.length;i++){
                    if (markedCheckbox[i].checked==true){
                        console.log("kkkkkk"+markedCheckbox.length)
                        /*data={deleteid:"markedCheckbox[i].value"};
                        []*/
                        //checkedarray.push(markedCheckbox[i].value)
                        //console.log(markedCheckbox[i].name)
                        data={deleteid:(markedCheckbox[i].value)}
                        checkedarray.push(data)
                       /* var ab=[{
                            names:2
                        },
                        {
                            names:3
                        }]
                        JSON.parse(ab);

                            {}
                        */

                        /*let a=JSON.parse({markedCheckbox[i].name:"markedCheckbox[i].value"})
                        console.log(a)*/
                      /*  arrays=JSON.parse(checkedarray);
                        console.log("uuu"+arrays);
                        console.log(checkedarray)
                        sessionStorage.setItem("deleteArray",checkedarray);*/

                    }
                }
                checkedarray=JSON.stringify(checkedarray);
                appComponents.ajaxPostFunction.ajaxwithreturn("http://localhost:8080/HospitalwebProject/delete/data",
                    checkedarray);




                /*appComponents.htmlTable.renders()*/
                /*let checkedarray=new Array();
                for (var i=0;i<checks.length;i++){
                    if (checks[i].checked()){checks
                        checkedarray.push(checks[i].value)
                    }

                }
                console.log(checkedarray)*/

            }

        }
        ]
}