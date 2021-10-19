appComponents.htmlForm.render.call({
    url: "admission/save",
    method: "POST",
    formTitle: 'Admission',
    renderId: "admitForm",
    items: [{
        label: "Patient ID",
        name: "patientId",
        id: "patientId",
        type: "number"
    },{
        label: "Staff ID",
        name: "staffId",
        id: "staffId",
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
});
