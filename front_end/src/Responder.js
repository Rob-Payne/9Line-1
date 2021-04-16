import Request from './Request';
import React from 'react';
import PropTypes from 'prop-types';


const Responder = (props) => {
    return (<div key={"responderdiv" + props.current}> {/*responder table title
         <table>

            <tr>
                <th> Location </th>
                <th> call sign </th>
                <th> urgency </th>
                <th> responder </th>
                <th> Completed </th>
            </tr> */}
            Responder Table
        <table class="responder-table">
            <tr class="responder-table">
                <th class="responder-table">Urgency</th>
                <th class="responder-table">Location</th>
                <th class="responder-table">Callsign</th>
                <th class="responder-table">Responder</th>
                <th class="responder-table">Completed</th>
            </tr>

            {props.requests.map(
                (request, i) => {
                    if (request.responder === props.current && !request.completed) {
                        return (<Request key={"" + request.id + i + request.responder + request.completed} requestObject={request} completeClick={props.completeClick} />

                        )
                    }
                })}
        </table>
    </div>);
}






Responder.propTypes = {
    requests: PropTypes.array,
    completeClick: PropTypes.func,
    current: PropTypes.string,
}

export default Responder;
