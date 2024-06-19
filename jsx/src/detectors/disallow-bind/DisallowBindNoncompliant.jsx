/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=disallow-bind@v1.0 defects=1}
const nonCompliant = ({ onClick }) => {
    // Noncompliant: Arrow function recreated on every render.
    return <button onClick={() => onClick()}>Click me</button>;
};
// {/fact}
