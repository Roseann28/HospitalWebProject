appComponents.homepage.homeRender.call({
    renderTo:'home',
    url:'staffs/list',
    items:[
        {
            dataIndex:'name'
        },
        {
            dataIndex: 'department'
        },
        {
            dataIndex: 'specialisation'
        }
    ],
    links:{
        hreflink:'../DoctorList.jsp',
        display:'Details'
    }
})