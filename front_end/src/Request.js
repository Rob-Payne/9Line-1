import PropTypes from 'prop-types';

const Request = (props) => {

    //trying to make it easily draw a row item for each field
    // function ResponseBuilder() {
    //     var tempstr = ""
    //     if (!props.requestObject.assigned) {
    //         tempstr += "<input type = \"radial\" />"
    //     }
    //     for (var value in props.requestObject) {
    //         tempstr += "<tr> " + value + "</tr>"
    //     }
    //     if (props.requestObject.assigned) {
    //         tempstr += "<button  > complete </button>"

    //     }
    //     return tempstr
    // }

    return (
        <tr key={"" + props.requestObject.id + props.requestObject.responder + props.requestObject.completed}>
            {/* ternary to hide radio when on a responder */}
            {!props.requestObject.responder ? (<td>
                <input type="radio" name="radioButton" onChange={() => { props.setCurrentMissionAssignment(props.requestObject) }}></input>
            </td>) : ""}

            <td> {props.requestObject.location} </td>
            <td> {props.requestObject.callSign} </td>
            <td> {props.requestObject.patientUrgency} </td>
            <td> {props.requestObject.responder} </td>
            {/* ternary to hide button when on dispatch */}
            {props.requestObject.responder ? (<td><button onClick={() => props.completeClick(props.requestObject.id)}>complete</button></td>) : ""}
        </tr>
    )

}


// {props.requestObject.responder? <td><button onClick={props.completeClick(props.requestObject.id)} >complete</button> </td>: ""}

Request.propTypes = {
    requestObject: PropTypes.object,


}

export default Request
