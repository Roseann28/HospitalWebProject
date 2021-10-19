let staffdetails={
    url: "http://localhost:8080/HospitalwebProject/staffs/list",
    tableTitle:'Staff Table',
    renderTo: 'renderer',
    columns:[{
        label:"Staff Id",
        dataIndex:"staffId",
    },{
        label:"Staff Name",
        dataIndex: "name",
    },{
        label:"Department",
        dataIndex: "department",
    },{
        label: "Specialisation",
        dataIndex: "specialisation"
    }],
    buttons:[
        {
            id: 'add.staff',
            label: 'add',
            handler: function () {
                appComponents.htmlForm.render.call({
                    url: "staffs/save",
                    method: "POST",
                    formTitle: 'Staff List',
                    renderId: 'renderer',
                    items: [{
                        label: "Staff ID",
                        name: "staffId",
                        id: "staffId",
                        type: "number"
                    }, {
                        label: "Staff Name",
                        name: "name",
                        id: "name",
                        type: "text"
                    }, {
                        label: "Department",
                        name: "department",
                        id: "department",
                        type: "text"
                    }, {
                        label: "Specialisation",
                        name: "specialisation",
                        id: "specialisation",
                        type: "text"
                    }
                    ],
                    submitBtn: {
                        type: 'submit',
                        value: 'Submit'
                    }
                })
            }
        }]
}