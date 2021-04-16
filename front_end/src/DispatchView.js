import React from 'react';
import PropTypes from 'prop-types';
import Request from './Request';
import './App.css';
import { Select } from 'react-dropdown-select'

const DispatchView = (props) => {


    return (
        <div>
            _____________________________________
            <br />
            Dispatch Table
            <br />
            <table class="dispatch-table">
                <tr class="dispatch-table">
                    <th class="dispatch-table">Select</th>
                    <th class="dispatch-table">Location</th>
                    <th class="dispatch-table">Callsign</th>
                    <th class="dispatch-table">Priority</th>
                </tr>
                {props.requests.map(
                    (request, index) => {
                        if (request.responder == "") {
                            return (
                                <Request
                                    key={index}
                                    requestObject={request}
                                    currentMissionAssignment={props.currentMissionAssignment}
                                    setCurrentMissionAssignment={props.setCurrentMissionAssignment}
                                />
                            )
                        }
                    }
                )}
            </table>
            <br />
            <Select options={props.responderList} onChange={(choice) => props.setCurrentResponderAssignment(choice)} />
            <button onClick={() => { props.assignResponder(props.currentResponderAssignment) }}>Assign to Mission</button>
            {/* onChange={(choice) => this.setCurrentSelection(choice)}  */}
            <br />
___________________________________<br />

        </div>);

}

DispatchView.propTypes = {
    requests: PropTypes.array,

}

export default DispatchView;
