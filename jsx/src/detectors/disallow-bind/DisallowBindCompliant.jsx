/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=disallow-bind@v1.0 defects=0}
const Compliant = ({ onClick }) => {
    // Compliant: Use `useCallback` to memoize the function.
    const memoizedOnClick = useCallback(() => onClick(), [onClick]);
    return <button onClick={memoizedOnClick}>Click me</button>;
};
// {/fact}
