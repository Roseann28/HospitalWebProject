appComponents.htmlForm.render.call({
    url: "test/save",
    method: "POST",
    formTitle: 'Tests',
    renderId: "testForm",
    items: [{
        label: "Patient ID",
        name: "patientId",
        id: "patientId",
        type: "number"
    },{
        label: "Lab Tech ID",
        name: "labTechId",
        id: "labTechId",
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
