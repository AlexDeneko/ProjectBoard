import React, {Component} from 'react';
import './App.css';
import "bootstrap/dist/css/bootstrap.min.css";
import Navbar from './components/Navbar';
import ProjectBoard from './components/ProjectBoard';
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import AddProjectTask from './components/ProjectTask/AddProjectTask';
import {Provider} from "react-redux"
import store from './store';
import UpdateProjectTask from './components/ProjectTask/UpdateProjectTask';

class App extends Component {
  render(){
    return (
      <Provider store={store}>
        <Router>
          <div className="App">
            <Navbar />
            <Switch>
              <Route exact path="/">
                <ProjectBoard />
              </Route>
              <Route exact path="/addProjectTask">
              <AddProjectTask />
              </Route>
              <Route exact path="/updateProjectTask/:pt_id">
              <UpdateProjectTask />
              </Route>
            </Switch>
          </div>
        </Router>
      </Provider>
    );
  }
}

export default App;
