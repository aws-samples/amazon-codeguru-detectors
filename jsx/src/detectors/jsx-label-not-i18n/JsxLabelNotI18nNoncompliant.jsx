/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import { useTranslation } from 'react-i18next';

// {fact rule=jsx-label-not-i18n@v1.0 defects=1}
const nonCompliant = () => {
    const { t } = useTranslation();

    // Noncompliant: Label prop of the TextField component using a hardcoded string value.
    return (
        <TextField
            id="outlined-basic"
            label="Add extra amount"
            variant="outlined"
            sx={{ width: '100%' }}
            value={text}
            onChange={e => setText(e.target.value)}
        />
    );
};
// {/fact}
