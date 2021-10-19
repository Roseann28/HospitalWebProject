let patientdetails={

    url: "http://localhost:8080/HospitalwebProject/patient/list",
    tableTitle:'Patients Table',
    renderTo: 'renderer',
    columns:[{
        label:"Id",
        dataIndex:"id"
    },{
        label:"Patient Name",
        dataIndex: "name",
    },{
        label:"Email",
        dataIndex: "email",
    },{
        label: "National ID",
        dataIndex: "nationalId"
    },{
        label: "Payment Method",
        dataIndex: "paymentMethod"
    },{
        label: "Date Of Birth",
        dataIndex: "dateOfBirth"
    },{
        label: "Specialist",
        dataIndex: "specialist"
    },{
        label: "Doctor",
        dataIndex: "doctor"
    }],
    buttons:[
        {
            id:'add.patient',
            label:'add',
            handler: function () {

                appComponents.htmlForm.render.call({
                    url: "patient/save",
                    method: "POST",
                    formTitle: 'Patient details',
                    renderId:'renderer',

                    items: [{
                        label: "Patient Name:",
                        name: "name",
                        id: "name",
                        type: "text"
                    },{
                        label: "Email:",
                        name: "email",
                        id: "email",
                        type: "email"
                    },{
                        label: "National ID:",
                        name: "nId",
                        id: "nId",
                        type: "number"
                    },{
                        label: "Payment Method:",
                        name: "pMethod",
                        id: "pMethod",
                        type: "text"
                    },{
                        label: "Date of Birth:",
                        name: "dob",
                        id: "dob",
                        type: "date"
                    },{
                        label: "specialist:",
                        name: "specialist",
                        id: "specialist",
                        type: "text"
                    },{
                        label: "doctor:",
                        name: "doctor",
                        id: "doctor",
                        type: "text"
                    }],
                    submitBtn: {
                        type: 'submit',
                        value: 'Submit'
                    }
                });


            }
        }
        /*{
            id:"delete",
            label: "delete",
            handler: function (){
                let allCheckBoxes=document.getElementsByClassName('check');
                for (var i=0;i<allCheckBoxes.length;i++){
                    checkBox=allCheckBoxes[i];
                    if (checkBox.checked){
                        checkBox.parentNode.removeChild(checkBox);
                    }
                }
            }


        }*/]
}