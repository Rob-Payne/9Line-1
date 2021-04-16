import { Component } from 'react'
import PropTypes from 'prop-types';
import { Dropdown, Container, Img } from 'react-bootstrap'
import { ThemeConsumer } from 'react-bootstrap/esm/ThemeProvider';
import './index.css';

class NineLineCreator extends Component {
    constructor(props) {
        super(props);
        this.state = {
            location: '',
            callSign: '',
            patientUrgency: '',
            specialEquipment: '',
            patientType: '',
            security: '',
            hlzMarking: '',
            nationality: '',
            nbc: '',
        }
        this.onChangeValue = this.onChangeValue.bind(this);
        this.handleUrgency = this.handleUrgency.bind(this);
        this.handleEquipment = this.handleEquipment.bind(this);
        this.handleType = this.handleType.bind(this);
        this.handleSecurity = this.handleSecurity.bind(this);
        this.handleMarking = this.handleMarking.bind(this);
        this.handleNationality = this.handleNationality.bind(this);
        this.handleNBC = this.handleNBC.bind(this);
    }


    onChangeValue(event) {
        this.setState({ [event.target.name]: event.target.value })
    }

    handleUrgency(e){
        let patientUrgency = e.target.value;
        this.setState({ patientUrgency: e.target.value });
        console.log(patientUrgency);
    }
    handleEquipment(e){
        let specialEquipment = e.target.value;
        this.setState({ specialEquipment: e.target.value });
        console.log(specialEquipment);
    }
    handleType(e){
        let patientType = e.target.value;
        this.setState({ patientType: e.target.value });
        console.log(patientType);
    }
    handleSecurity(e){
        let security = e.target.value;
        this.setState({ security: e.target.value });
        console.log(security);
    }
    handleMarking(e){
        let hlzMarking = e.target.value;
        this.setState({ hlzMarking: e.target.value });
        console.log(hlzMarking);
    }
    handleNationality(e){
        let nationality = e.target.value;
        this.setState({ nationality: e.target.value });
        console.log(nationality);
    }    
    handleNBC(e){
        let nbc = e.target.value;
        this.setState({ nbc: e.target.value });
        console.log(nbc);
    }

    render() {

        return (
            <div>
                <fieldset onChange={this.onChangeValue}>
                    {"Location:  "}<br/>
                    <input defaultValue="Line 1" value={this.state.location} name="location"></input><br/>
                    {"Call Sign:  "}<br/>
                    <input defaultValue="Line 2" value={this.state.callSign} name="callSign"></input><br /> 
                    {"Patient Urgency:  "}<br/>
                    <select value={this.state.patientUrgency} onChange={this.handleUrgency}> 
                        <option value='Select one'>Select One</option>,
                        <option value='A – Urgent'>A – Urgent</option>,
                        <option value='B – Urgent Surgical'>B – Urgent Surgical</option>
                        <option value='C – Priority'>C – Priority</option>
                        <option value='D – Routine'>D – Routine</option>
                        <option value='E – Convenience'> E – Convenience </option>
                    </select><br></br>
                    {"Special Equipment:  "}<br></br>
                    <select value={this.state.specialEquipment} onChange={this.handleEquipment}>        
                        <option value='Select one'>Select One</option>,
                        <option value='A – None'>A – None</option>,
                        <option value='B – Hoist'>B – Hoist</option>
                        <option value='C – Extraction equipment'>C – Extraction equipment</option>
                        <option value='D – Ventilator'>D – Ventilator</option>
                    </select><br></br>
                    {"Patient Type:  "}<br></br>
                    {/* <input defaultValue="Line 5" value={this.state.patientType} name="patientType"></input><br /> */}
                    <select value={this.state.patientType} onChange={this.handleType}>        
                        <option value='Select one'>Select One</option>,
                        <option value='A – Litter'>A – Litter</option>,
                        <option value='B – Ambulatory'>B – Ambulatory</option>
                    </select><br></br>
                    {"Security: "}<br></br>
                    {/* <input defaultValue="Line 6" value={this.state.security} name="security"></input><br /> */}
                    <select value={this.state.security} onChange={this.handleSecurity}>        
                        <option value='Select one'>Select One</option>,
                        <option value='N – No enemy troops in area'>N – No enemy troops in area</option>,
                        <option value='P – Possible enemy troops in area (approach with caution)'>P – Possible enemy troops in area (approach with caution)</option>
                        <option value='E – Enemy troops in area (approach with caution)'>E – Enemy troops in area (approach with caution)</option>
                        <option value='X – Enemy troops in area (armed escort required)'>X – Enemy troops in area (armed escort required)</option>
                    </select><br></br>
                    {"hlzMarking: "}<br></br>
                    {/* <input defaultValue="Line 7" value={this.state.hlzMarking} name="hlzMarking"></input><br /> */}
                    <select value={this.state.hlzMarking} onChange={this.handleMarking}>        
                        <option value='Select one'>Select One</option>,
                        <option value='A – Panels'>A – Panels</option>,
                        <option value='B – Pyrotechnic signal'>B – Pyrotechnic signal</option>,
                        <option value='C – Smoke signal'>C – Smoke signal</option>,
                        <option value='D – None'>D – None</option>,
                        <option value='E – Other'>E – Other</option>,
                    </select><br></br>
                    {"Nationality: "}<br></br>
                    {/* <input defaultValue="Line 8" value={this.state.nationality} name="nationality"></input><br /> */}
                    <select value={this.state.nationality} onChange={this.handleNationality}>        
                        <option value='Select one'>Select One</option>,
                        <option value='A – US Military'>A – US Military</option>,
                        <option value='B – US Civilian'>B – US Civilian</option>,
                        <option value='C – Non-US Military'>C – Non-US Military</option>,
                        <option value='D – Non-US Civilian'>D – Non-US Civilian</option>,
                        <option value='E – EPW'>E – EPW</option>,
                    </select><br></br>
                    {"NBC: "}<br></br>
                    {/* <input defaultValue="Line 9" value={this.state.nbc} name="nbc"></input><br /> */}
                    <select value={this.state.nbc} onChange={this.handleNBC}>        
                        <option value='Select one'>Select One</option>,
                        <option value='None'>None</option>,
                        <option value='N – Nuclear'>N – Nuclear</option>,
                        <option value='B – Biological'>B – Biological</option>,
                        <option value='C – Chemical'>C – Chemical</option>,
                    </select><br></br>
                    <button onClick={() => (this.state.location && this.state.callSign && this.state.patientUrgency && this.state.specialEquipment && this.state.patientType) ? this.props.handleNewRequest(this.state) : alert("Please Provide Data for Lines 1 through 5")}>Submit</button>
                </fieldset>
                </div>
        );

    }

}


export default NineLineCreator;