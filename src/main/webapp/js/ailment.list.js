let ailmentlist={
    url: "http://localhost:8080/HospitalwebProject/ailment/list",
    tableTitle:'Ailment Table',
    renderTo: 'renderer',
    columns:[{
        label:"Patient Id",
        dataIndex:"patientId",
    },{
        label:"Doctor Id",
        dataIndex: "doctorId",
    },{
        label:"Ailment",
        dataIndex: "ailment",
    },{
        label: "Medicine",
        dataIndex: "medicine"
    },{
        label: "Test",
        dataIndex: "test"
    },{
        label: "Admitted",
        dataIndex: "admitted"
    }],
    buttons:[
        {
            id:'add.ailment',
            label:'add',
            handler: function () {
                appComponents.htmlForm.render.call({
                    url: "ailment/save",
                    method: "POST",
                    formTitle: 'Doctor\'s prescription',
                    renderId:'renderer',
                    items: [{
                        label: "Patient ID",
                        name: "patientId",
                        id: "patientId",
                        type: "number"
                    },{
                        label: "ailment",
                        name: "ailment",
                        id: "ailment",
                        type: "text"
                    },{
                        label: "Medicine",
                        name: "medicine",
                        id: "medicine",
                        type: "text"
                    },{
                        label: "Test",
                        name: "test",
                        id: "test",
                        type: "text"
                    },{
                        label: "Admit",
                        name: "admitted",
                        id: "admitted",
                        type: "text"
                    }],
                    submitBtn: {
                        type: 'submit',
                        value: 'Submit'
                    }
                });


            }
        }]
}