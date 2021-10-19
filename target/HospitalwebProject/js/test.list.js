let testdetails={
    url: "http://localhost:8080/HospitalwebProject/test/list",
    tableTitle:'Test Table',
    renderTo: 'renderer',
    id:'patientId',
    columns:[{
        label:"Patient Id",
        dataIndex:"patientId",
    },{
        label:"Lab Tech ID",
        dataIndex: "labTechId",
    },{
        label:"Test Name",
        dataIndex: "testName",
    },{
        label: "Finding",
        dataIndex: "finding"
    }],
    buttons:[
        {
            id:'add.test',
            label:'add',
            handler: function () {
                appComponents.htmlForm.render.call({
                    url: "test/save",
                    method: "POST",
                    formTitle: 'Tests',
                    renderId:'renderer',
                    items: [{
                        label: "Patient ID",
                        name: "patientId",
                        id: "patientId",
                        type: "number"
                    },{
                        label: "Test Name",
                        name: "testName",
                        id: "testName",
                        type: "text"
                    },{
                        label: "Findings",
                        name: "finding",
                        id: "finding",
                        type: "textarea"
                    }],
                    submitBtn: {
                        type: 'submit',
                        value: 'Submit'
                    }
                });



            }
        }]
}