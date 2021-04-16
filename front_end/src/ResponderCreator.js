import React from 'react';
import PropTypes from 'prop-types';


class ResponderCreator extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            callSignInput: "",
            addResponder: "",
        }
        this.handleCallSign = this.handleCallSign.bind(this)
    }
    handleCallSign(event) {
        this.setState({ callSignInput: event.target.value });
    }


    //
    /*
    √ addResponder moved to App.js  
    √ passed as a prop to respondercreator

    √ addResponder in App.js will update state of responderList by appending a new value to the list 
    √ 1. responderList.push(new_responder)
    */

    //data type to format of lists in app
    //{ value: "DustOff 1", label: "Dustoff1" },

    render() {
        return (
            <div>
                {'Responder Call Sign: '} {" "}
                <input type="text"
                    value={this.state.callSignInput}
                    onChange={this.handleCallSign}
                    placeholder="Call Sign"
                />
                <button onClick={() => this.props.addResponder(
                    {
                        value: this.state.callSignInput,
                        label: this.state.callSignInput
                    })}
                >
                    Add Responder
                </button>

            </div>

        );
    }
}

ResponderCreator.propTypes = {

}

export default ResponderCreator;