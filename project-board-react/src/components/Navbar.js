import React from 'react';
import { Link } from 'react-router-dom';

export default function Navbar() {
  return( 
    <nav className="navbar navbar-expand-sm navbar-dark bg-primary mb-4">
        <div className="container">
            <Link className="navbar-brand" to="/">
                Project Task Tool
            </Link>
            <button LinklassName="navbar-toggler" type="button" data-toggle="collapse" data-target="#mobile-nav">
                <span claLinksName="navbar-toggler-icon" />
            </button>
        </div>
    </nav>
  );
}
