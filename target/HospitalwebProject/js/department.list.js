let departmentdetails={
    url: "http://localhost:8080/HospitalwebProject/department/list",
    tableTitle:'Department Table',
    renderTo: 'renderer',
    columns:[
        {
            label:'Department Id',
            dataIndex:'departmentId'
        },
        {
            label: 'Department Name',
            dataIndex: 'depertmentName'
        }
    ],
    buttons:[
        {
            id:'add.department',
            label:'add',
            handler:function () {
                appComponents.htmlForm.render.call({
                    url: "departments/save",
                    method: "POST",
                    formTitle: 'Department Addition',
                    renderId: "renderer",
                    items:[
                        {
                            label: "Department Name",
                            name: "depertmentName",
                            id: "depertmentName",
                            type: "text"

                        }
                    ],
                    submitBtn: {
                        type: 'submit',
                        value: 'Submit'
                    }
                })


            }
        }
    ]
}