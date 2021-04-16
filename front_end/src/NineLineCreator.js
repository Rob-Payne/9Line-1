import { Component } from 'react'
import PropTypes from 'prop-types';
import { Dropdown, Container, Img } from 'react-bootstrap'


class NineLineCreator extends Component {
    constructor(props) {
        super(props);
        this.state = {
            location: '',
            callSign: '',
            patientUrgency: [],
            specialEquipment: '',
            patientType: '',
            security: '',
            hlzMarking: '',
            nationality: '',
            nbc: '',

            //from java backend:
            // private String location;
            // private String callSign;
            // private String patientUrgency;
            // private String specialEquipment;
            // private String patientType;
            // private String security;
            // private String hlzMarking;
            // private String nationality;
            // private String nbc; //line9; //special
        }
        this.onChangeValue = this.onChangeValue.bind(this)
    }

// drop downs for each 9line item 
// componentDidMount() {
//     this.setState({
//         patientUrgency: [
//             {id: 'A – Urgent', name: 'A – Urgent'},
//             {id: 'B – Urgent Surgical', name: 'B – Urgent Surgical'},
//             {id: 'C – Priority', name: 'C – Priority'},
//             {id: 'D – Routine', name: 'D – Routine'},
//             {id: 'E – Convenience', name: 'E – Convenience'}
//         ]
//     });
// }

    onChangeValue(event) {
        this.setState({ [event.target.name]: event.target.value })
    }

    render() {
    // const {patientUrgency}
        return (
            // Lines two contains side by side
            // prep for later user use accordion functions

            // <div class="container">
            //     <div class="row">
            //         <div class="col">
            //             {"Location: "}<br></br>
            //             {"Call Sign: "}<br></br>
            //             {"Patient Urgency: "}<br></br>
            //             {"Special Equipment: "}<br></br>
            //             {"Patient Type: "}<br></br>
            //             {"Security: "}<br></br>
            //             {"hlzMarking: "}<br></br>
            //             {"Nationality: "}<br></br>
            //             {"NBC: "}<br></br>
            //         </div>
            //         <div class="col">
            //             <fieldset onChange={this.onChangeValue}>
            //                 <input defaultValue="Line 1" value={this.state.location} name="location"></input><br/>
            //                 <input defaultValue="Line 2" value={this.state.callSign} name="callSign"></input><br/>
            //                 <input defaultValue="Line 3" value={this.state.patientUrgency} name="patientUrgency"></input><br/>
            //                 <input defaultValue="Line 4" value={this.state.specialEquipment} name="specialEquipment"></input><br/>
            //                 <input defaultValue="Line 5" value={this.state.patientType} name="patientType"></input><br/>
            //                 <input defaultValue="Line 6" value={this.state.security} name="security"></input><br/>
            //                 <input defaultValue="Line 7" value={this.state.hlzMarking} name="hlzMarking"></input><br/>
            //                 <input defaultValue="Line 8" value={this.state.nationality} name="nationality"></input><br/>
            //                 <input defaultValue="Line 9" value={this.state.nbc} name="nbc"></input><br/>
            //             <button onClick={() => (this.state.location && this.state.callSign && this.state.patientUrgency && this.state.specialEquipment && this.state.patientType)?this.props.handleNewRequest(this.state):alert("Please Provide Data for Lines 1 through 5")}>Submit</button>
            //             </fieldset>
            //         </div>
            //     </div>
            // </div>
            <div>
                <fieldset onChange={this.onChangeValue}>
                    {"Location: "}<br></br>
                    <input defaultValue="Line 1" value={this.state.location} name="location"></input><br />
                    {"Call Sign: "}<br></br>
                    <input defaultValue="Line 2" value={this.state.callSign} name="callSign"></input><br />
                    {"Patient Urgency: "}<br></br>
                    <input defaultValue="Line 3" value={this.state.patientUrgency} name="patientUrgency"></input><br />
                    {"Special Equipment: "}<br></br>
                    <input defaultValue="Line 4" value={this.state.specialEquipment} name="specialEquipment"></input><br />
                    {"Patient Type: "}<br></br>
                    <input defaultValue="Line 5" value={this.state.patientType} name="patientType"></input><br />
                    {"Security: "}<br></br>
                    <input defaultValue="Line 6" value={this.state.security} name="security"></input><br />
                    {"hlzMarking: "}<br></br>
                    <input defaultValue="Line 7" value={this.state.hlzMarking} name="hlzMarking"></input><br />
                    {"Nationality: "}<br></br>
                    <input defaultValue="Line 8" value={this.state.nationality} name="nationality"></input><br />
                    {"NBC: "}<br></br>
                    <input defaultValue="Line 9" value={this.state.nbc} name="nbc"></input><br />
                    <button onClick={() => (this.state.location && this.state.callSign && this.state.patientUrgency && this.state.specialEquipment && this.state.patientType) ? this.props.handleNewRequest(this.state) : alert("Please Provide Data for Lines 1 through 5")}>Submit</button>
                </fieldset>
            </div>



        );

    }

}


export default NineLineCreator;
