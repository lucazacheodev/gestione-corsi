export const API_BASE = 'http://localhost:8080';

export async function handleApiError(res: Response, defaultMsg: string): Promise<never> {
  let errorMsg = defaultMsg;
  try {
    const errJson = await res.json();
    if (errJson.message) errorMsg = errJson.message;
    if (errJson.details) {
      if (typeof errJson.details === 'string') {
        errorMsg += `: ${errJson.details}`;
      } else if (typeof errJson.details === 'object') {
        errorMsg += ': ' + Object.entries(errJson.details).map(([k, v]) => `${k}: ${v}`).join(', ');
      }
    }
  } catch {}
  throw new Error(errorMsg);
}