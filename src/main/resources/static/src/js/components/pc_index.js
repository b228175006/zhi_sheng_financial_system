/**
 * Created by bili on 2017/6/18.
 */
import React from 'react'
import PCLogin from './pc_login';
export default class PCIndex extends React.Component{
    constructor(){
        super();
    }
    componentWillMount(){
        if(!localStorage.userId){
            location.href="/";
        }
    }
    render(){
        console.log(this.props.params.uniquekey);
        return (
            <div>
                {this.props.params.uniquekey}
            </div>
        )
    }
}