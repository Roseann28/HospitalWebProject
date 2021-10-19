let basiclist={
    url: "http://localhost:8080/HospitalwebProject/basics/list",
    tableTitle:'Basic Table',
    renderTo: 'renderer',
    columns:[{
        label:"Patient Id",
        dataIndex:"id",
    },{
        label:"Height",
        dataIndex: "height",
    },{
        label:"Weight",
        dataIndex: "weight",
    },{
        label: "Blood Pressure",
        dataIndex: "bloodPressure"
    }],
    buttons:[
        {
            id:'add.basic',
            label:'add',
            handler: function () {
                appComponents.htmlForm.render.call({
                    url: "basics/save",
                    method: "POST",
                    formTitle: 'Basic Measurements',
                    renderId:'renderer',
                    items: [{
                        label: "Patient ID",
                        name: "id",
                        id: "id",
                        type: "number"
                    },{
                        label: "Height",
                        name: "height",
                        id: "height",
                        type: "number"
                    },{
                        label: "Height Unit",
                        name: "heightUnit",
                        id: "heightUnit",
                        type: "text"
                    },{
                        label: "Weight",
                        name: "weight",
                        id: "weight",
                        type: "number"
                    },{
                        label: "Weight Unit",
                        name: "weightUnit",
                        id: "weightUnit",
                        type: "text"
                    },{
                        label: "Blood Pressure",
                        name: "bloodPressure",
                        id: "bloodPressure",
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