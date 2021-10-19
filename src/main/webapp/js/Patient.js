
    appComponents.htmlForm.render.call({
        url: "patient/save",
        method: "POST",
        formTitle: 'Patient details',
        renderId: "patientForm",

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
