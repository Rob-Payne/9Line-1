//Created by Joshua Schoonover and Rob Payne

CORS expecing port 3000
my port 9090

endpoints:
Dispatcher Controller:
Get /requests -get all
Get /requests/{id} -get by id, returns iterable<requests>
Patch /requests/{id} -patch by id, accepts responder (string), returns updated request

Responder Controller:
Get /responder/{name} - get all requests by responder id, returns iterable<requests>

Requester Controller:
Post /nineline - saves a nineline to the database, returns request

//--------------------------------------
NineLine:
    private String location;
    private String callSign;
    private String patientUrgency;
    private String specialEquipment;
    private String patientType;
    private String security;
    private String hlzMarking;
    private String nationality;
    private String nbc; //line9; //special

Request extends NineLine:
    private long id //table id
    private boolean completed
    private String responder //string for assigned responder

