appComponents.htmlForm.render.call({
    url: "ailment/save",
    method: "POST",
    formTitle: 'Doctor\'s prescription',
    renderId: "ailmentForm",
    items: [{
        label: "Patient ID",
        name: "patientId",
        id: "patientId",
        type: "number"
    },{
        label: "Doctor ID",
        name: "doctorId",
        id: "doctorId",
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
